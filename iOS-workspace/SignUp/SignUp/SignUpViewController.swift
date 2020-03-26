//
//  ViewController.swift
//  SignUp
//
//  Created by 임승혁 on 2020/03/23.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class SignUpViewController: UIViewController {
    
    @IBOutlet weak var idValidationLabel: ValidationLabel!
    @IBOutlet weak var pwValidationLabel: ValidationLabel!
    @IBOutlet weak var rePwValidationLabel: ValidationLabel!
    @IBOutlet weak var nameValidationLabel: ValidationLabel!
    
    @IBOutlet weak var idTextField: InfoTextField!
    @IBOutlet weak var passwordTextField: InfoTextField!
    @IBOutlet weak var rePasswordTextField: InfoTextField!
    @IBOutlet weak var nameTextField: InfoTextField!
    
    private var duplicateResponse: DuplicateCheck?
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    @IBAction func editBegin(_ sender: InfoTextField) {
        if sender.appearance != .invalid {
            sender.appearance = .focused
        }
    }
    
    @IBAction func editEnd(_ sender: InfoTextField) {
        if sender.appearance != .invalid {
            sender.appearance = .normal
        }
    }
    
    @IBAction func editingChanged(_ sender: InfoTextField) {
        switch sender {
        case idTextField:
            vaildateId()
            return
        case passwordTextField:
            vaildatePassword()
        case rePasswordTextField:
            validateRePassword()
            return
        case nameTextField:
            validateName()
            return
        default:
            return
        }
    }
    
    private func vaildateId() {
        idTextField.appearance = .invalid
        idValidationLabel.status = .wrong
        guard let id = idTextField.text, id.count <= 20 && id.count >= 5 else {
            idValidationLabel.text = "5자 이상 20자 이하로 입력해주세요."
            return
        }
        
        if id.validateUpperEngId() == false || id.validateSymbolId() == false {
            idValidationLabel.text = "5~20자의 영문 소문자, 숫자와 특수기호(_)(-) 만 사용 가능합니다."
            return
        }
        
        idTextField.appearance = .normal
        idValidationLabel.text = "사용 가능한 아이디입니다."
        idValidationLabel.status = .correct
    }
    
    private func vaildatePassword() {
        passwordTextField.appearance = .invalid
        pwValidationLabel.status = .wrong
        guard let password = passwordTextField.text, password.count <= 16 && password.count >= 8 else {
            pwValidationLabel.text = "8자 이상 16자 이하로 입력해주세요."
            return
        }
        
        if password.validateEngPassword() == false {
            pwValidationLabel.text = "영문 대문자를 최소 1자 이상 포함해주세요."
            return
        }
        
        if password.validateNumberPassword() == false {
            pwValidationLabel.text = "숫자를 최소 1자 이상 포함해주세요."
            return
        }
        
        if password.validateSymbolPassword() == false {
            pwValidationLabel.text = "특수문자를 최소 1자 이상 포함해주세요."
            return
        }
        
        pwValidationLabel.status = .correct
        pwValidationLabel.text = "안전한 비밀번호입니다."
        passwordTextField.appearance = .normal
    }
    
    private func validateRePassword() {
        guard let rePassword = rePasswordTextField.text else {
            return
        }
        
        if passwordTextField.text == rePassword {
            rePwValidationLabel.status = .correct
            rePwValidationLabel.text = "비밀번호가 일치합니다."
            rePasswordTextField.appearance = .normal
        } else {
            
            rePwValidationLabel.text = "비밀번호가 일치하지 않습니다."
            rePasswordTextField.appearance = .invalid
        }
    }
    
    private func validateName() {
        guard let name = nameTextField.text, name.count > 0 else {
            nameTextField.appearance = .invalid
            nameValidationLabel.status = .wrong
            nameValidationLabel.text = "이름은 필수 입력 항목입니다."
            return
        }
    }
}

extension SignUpViewController {
    func requestDuplicateId(inputId : String) -> Bool {
        guard let url = URL(string: "https://codesquad-signup4-testapis.herokuapp.com/api/users/duplicate/checkID?id=" + inputId) else { return false}
        let request = URLRequest(url: url)
        let dataTask = URLSession.shared.dataTask(with: request) { (data, response, error) in
            if let error = error { return }
            
            guard let data = data else { return }
            guard let responseData = try? JSONDecoder().decode(DuplicateCheck.self, from: data) else { return }
            self.duplicateResponse = responseData
        }
        dataTask.resume()
        return self.duplicateResponse!.valid
    }
}

