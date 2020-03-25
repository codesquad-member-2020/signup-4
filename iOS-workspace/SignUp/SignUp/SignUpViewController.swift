//
//  ViewController.swift
//  SignUp
//
//  Created by 임승혁 on 2020/03/23.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class SignUpViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    @IBAction func editBegin(_ sender: InfoTextField) {
        sender.appearance = .focused
    }
    
    @IBAction func editEnd(_ sender: InfoTextField) {
        sender.appearance = .normal
    }
}

