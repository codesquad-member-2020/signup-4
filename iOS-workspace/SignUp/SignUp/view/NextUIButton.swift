//
//  NextUIButton.swift
//  SignUp
//
//  Created by 임승혁 on 2020/03/26.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class NextUIButton: UIButton {

    override init(frame: CGRect) {
        super.init(frame: frame)
        setDefaultButton()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setDefaultButton()
    }

    private func setDefaultButton(){
        self.layer.borderColor = UIColor(named: "normalGray")?.cgColor
        self.layer.borderWidth = 1
    }
}
