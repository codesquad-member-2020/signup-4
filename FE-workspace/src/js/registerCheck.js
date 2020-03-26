import { REG_PATTERN, INFO_MESSAGE } from '../util/constant.js';
import { $select } from '../util/func.js';
import { STATE_USER_DATA } from './registerUserData.js'
import { printMessage } from './infoMessage.js';

export const checkID = (id, target) => {
  const ERROR = 'error';
  const REG = REG_PATTERN.userID;
  const MESSAGE = INFO_MESSAGE.userID;
  if (!REG.test(id)) return printMessage(MESSAGE.errorMsg, target, ERROR);
  STATE_USER_DATA.userID = id;
  return printMessage(MESSAGE.successMsg, target);
};

export const checkPW = (password, target) => {
  const ERROR = 'error';
  const REG = REG_PATTERN.password;
  const MESSAGE = INFO_MESSAGE.password;
  const MESSAGE_ERROR = MESSAGE.errorMsg;
  if (!REG.limit.test(password)) return printMessage(MESSAGE_ERROR.limit, target, ERROR);
  if (!REG.case.test(password)) return printMessage(MESSAGE_ERROR.case, target, ERROR);
  if (!REG.number.test(password)) return printMessage(MESSAGE_ERROR.number, target, ERROR);
  if (!REG.symbol.test(password)) return printMessage(MESSAGE_ERROR.symbol, target, ERROR);
  STATE_USER_DATA.password = password;
  return printMessage(MESSAGE.successMsg, target);
};

export const checkPWReconfirm = (checkValue, originalValue, target) => {
  const ERROR = 'error';
  const MESSAGE = INFO_MESSAGE.password_confirm;
  if (originalValue !== checkValue) return printMessage(MESSAGE.errorMsg, target, ERROR);
  STATE_USER_DATA.password_confirm = true;
  return printMessage(MESSAGE.successMsg, target);
};

export const checkEmail = (email, target) => {
  const ERROR = 'error';
  const REG = REG_PATTERN.email;
  const MESSAGE = INFO_MESSAGE.email;
  const MESSAGE_ERROR = MESSAGE.errorMsg;
  if (!REG.test(email)) return printMessage(MESSAGE_ERROR, target, ERROR);
  STATE_USER_DATA.email = email;
  return printMessage(MESSAGE.successMsg, target);
};

export const checkBirth = () => {};

export const checkMobile = (mobile, target) => {
  const ERROR = 'error';
  const REG = REG_PATTERN.mobile;
  const MESSAGE = INFO_MESSAGE.mobile;
  const MESSAGE_ERROR = MESSAGE.errorMsg;
  if (!REG.test(mobile)) return printMessage(MESSAGE_ERROR, target, ERROR);
  STATE_USER_DATA.mobile = mobile;
  return printMessage(MESSAGE.successMsg, target);
};

export const checkInterest = () => {};

export const checkSubmit = (userData) => {
  for (let [key, value] of Object.entries(userData)) {
    if(!value) return alertMessage(key);
  }
  resultSubmit(userData);
}

const alertMessage = (key) => {
  switch(key) {
    case 'userID':
      alert(`${INFO_MESSAGE.userID.submitMsg}`);
      $select(`#${key}`).focus();
    break;
    case 'password':
      alert(`${INFO_MESSAGE.password.submitMsg}`)
      $select(`#${key}`).focus();
    break;
    case 'password_confirm':
      alert(`${INFO_MESSAGE.password_confirm.submitMsg}`)
      $select(`#${key}`).focus();
    break;
    case 'userName':
      alert(`${INFO_MESSAGE.userName.submitMsg}`)
      $select(`#${key}`).focus();
    break;
    case 'birthYY':
      alert(`${INFO_MESSAGE.birthYY.submitMsg}`)
      $select(`#${key}`).focus();
    break;
    case 'birthMM':
      alert(`${INFO_MESSAGE.birthMM.submitMsg}`)
      $select(`#${key}`).focus();
    break;
    case 'birthYY':
      alert(`${INFO_MESSAGE.birthYY.submitMsg}`)
      $select(`#${key}`).focus();
    break;
    case 'gender':
      alert(`${INFO_MESSAGE.gender.submitMsg}`)
      $select(`#${key}`).focus();
    break;
    case 'email':
      alert(`${INFO_MESSAGE.email.submitMsg}`)
      $select(`#${key}`).focus();
    break;
    case 'mobile':
      alert(`${INFO_MESSAGE.mobile.submitMsg}`)
      $select(`#${key}`).focus();
    break;
    case 'interest':
      alert(`${INFO_MESSAGE.interest.submitMsg}`)
      $select(`#${key}`).focus();
    break;
    case 'agree':
      alert(`${INFO_MESSAGE.agree.submitMsg}`)
      $select(`#${key}`).focus();
    break;
  }
}

const resultSubmit = (userData)=> {
  console.log('최종 결과 제출')
  //JSON 으로 담아서 페이지 전송
}