//
//  infoTextField.swift
//  SignUp
//
//  Created by 임승혁 on 2020/03/24.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class InfoTextField: UITextField {
    
    enum Appearance {
        case normal
        case focused
        case invalid
    }
    
    let padding = UIEdgeInsets(top: 0, left: 10, bottom: 0, right: 5)
    var appearance: Appearance = .normal {
        didSet {
            setAppearance(to: appearance) }
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setAppearance(to: .normal)
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setAppearance(to: .normal)
    }
    
    override open func textRect(forBounds bounds: CGRect) -> CGRect {
        return bounds.inset(by: padding)
    }
    
    override open func placeholderRect(forBounds bounds: CGRect) -> CGRect {
        return bounds.inset(by: padding)
    }
    
    override open func editingRect(forBounds bounds: CGRect) -> CGRect {
        return bounds.inset(by: padding)
    }

    func setAppearance(to appearance: Appearance) {
        switch appearance {
        case .normal: self.layer.borderColor = UIColor(named: "normalGray")?.cgColor
        case .focused: self.layer.borderColor = UIColor(named: "focusBlue")?.cgColor
        case .invalid: self.layer.borderColor = UIColor(named: "errorRed")?.cgColor
        }
        self.layer.borderWidth = 1
    }
}
