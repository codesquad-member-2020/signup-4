//
//  ValidationLabel.swift
//  SignUp
//
//  Created by 임승혁 on 2020/03/25.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class ValidationLabel: UILabel {
    
    enum Status {
        case editing
        case correct
        case wrong
    }
    
    var status: Status = .editing {
        didSet {
            setStatus(to: status) }
    }

    override init(frame: CGRect) {
        super.init(frame: frame)
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
    func setStatus(to status: Status) {
        switch status {
        case .editing:
            self.isHidden = true
        case .correct:
            self.textColor = UIColor(named: "textGreen")
        case .wrong:
            self.textColor = UIColor(named: "errorRed")
        }
    }
}
