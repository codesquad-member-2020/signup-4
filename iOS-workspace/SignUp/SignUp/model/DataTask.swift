//
//  File.swift
//  SignUp
//
//  Created by 임승혁 on 2020/03/26.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

class DataTask {
    let defaultSession = URLSession(configuration: .default)
    var dataTask: URLSessionDataTask?
    
    func requestDuplicateId(inputId : String) {
        /*
        var urlComponent = URLComponents(string: "https://codesquad-signup4-testapis.herokuapp.com/api/users/duplicate/checkID")
        urlComponent?.query = "id=\(inputId)"
        
        guard let url = urlComponent?.url else { return }
 */
        guard var urlComponent = URLComponents(string: "https://codesquad-signup4-testapis.herokuapp.com/api/users/duplicate/checkID") else { print("urlComponentfail"); return; }
        
        let queryItemToken = URLQueryItem(name: "id", value: inputId)
        urlComponent.queryItems = [queryItemToken]
        
        guard let url = urlComponent.url else { return }
        let request = URLRequest(url: url)
        dataTask = defaultSession.dataTask(with: request) { (data, response, error) in
            if let error = error { print(error); return }
            
            guard let data = data, let responseData = try? JSONDecoder().decode(DuplicateCheck.self, from: data) else { print("fail"); return; }
            DispatchQueue.main.async {
                NotificationCenter.default.post(name: .textFieldChange, object: nil, userInfo: ["validStatus":responseData.valid])
            }
        }
        dataTask!.resume()
    }
}
