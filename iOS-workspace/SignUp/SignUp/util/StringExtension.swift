//
//  StringExtension.swift
//  SignUp
//
//  Created by 임승혁 on 2020/03/25.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

extension String {
    func validateEngPassword() -> Bool {
        let engValidateRegex = "[A-Z]"
        let predict = NSPredicate(format: "SELF MATCHES %@", engValidateRegex)
        return predict.evaluate(with: self)
    }
    
    func validateNumberPassword() -> Bool {
        let numValidateRegex = "/^(?=.*[0-9])/"
        let predict = NSPredicate(format: "SELF MATCHES %@", numValidateRegex)
        
        return predict.evaluate(with: self)
    }
    
    func validateSymbolPassword() -> Bool {
        let symbolValidateRegex = "/^(?=.*[!@#$%^*+=-])/"
        let predict = NSPredicate(format: "SELF MATCHES %@", symbolValidateRegex)
        
        return predict.evaluate(with: self)
    }
}
