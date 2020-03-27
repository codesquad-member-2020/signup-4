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
        let regularExpression = try! NSRegularExpression(pattern: "[A-Z]", options: .anchorsMatchLines)
        let result = regularExpression.matches(in: self, options: [], range: NSRange(location: 0, length: self.count))
        return !result.isEmpty
    }
    
    func validateNumberPassword() -> Bool {
        let regularExpression = try! NSRegularExpression(pattern: "[0-9]", options: .anchorsMatchLines)
        let result = regularExpression.matches(in: self, options: [], range: NSRange(location: 0, length: self.count))
        return !result.isEmpty
    }
    
    func validateSymbolPassword() -> Bool {
        let regularExpression = try! NSRegularExpression(pattern: "[!@#$%]", options: .anchorsMatchLines)
        let result = regularExpression.matches(in: self, options: [], range: NSRange(location: 0, length: self.count))
        return !result.isEmpty
    }
    
    func validateUpperEngId() -> Bool {
        let regularExpression = try! NSRegularExpression(pattern: "[A-Z]", options: .anchorsMatchLines)
        let result = regularExpression.matches(in: self, options: [], range: NSRange(location: 0, length: self.count))
        return result.isEmpty
    }
    
    func validateSymbolId() -> Bool {
        let regularExpression = try! NSRegularExpression(pattern: "[`~!@#$%^&*()\\=+\\[{\\}\\\\|;:'\",<.>/?//]", options: .anchorsMatchLines)
        let result = regularExpression.matches(in: self, options: [], range: NSRange(location: 0, length: self.count))
        return result.isEmpty
    }
}
