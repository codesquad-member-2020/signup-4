//
//  DuplicateCheck.swift
//  SignUp
//
//  Created by 임승혁 on 2020/03/26.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

struct DuplicateCheck: Decodable {
    var valid: Bool
    var errorMessage: String?
}
