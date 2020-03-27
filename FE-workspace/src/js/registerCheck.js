import { REG_PATTERN, INFO_MESSAGE } from '../util/constant.js';
import { $select, $selectAll } from '../util/func.js';
import { STATE_USER_DATA, JSON_USER_DATA } from './registerUserData.js';
import { printMessage } from './infoMessage.js';
import { clearTag } from './registerInterest.js';

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

export const checkSubmit = userData => {
  for (let [key, value] of Object.entries(userData)) {
    if (!value) return alertMessage(key);
  }
  resultSubmit(userData);
};

const alertMessage = key => {
  switch (key) {
    case 'userID':
      alert(`${INFO_MESSAGE.userID.submitMsg}`);
      $select(`#${key}`).focus();
      break;
    case 'password':
      alert(`${INFO_MESSAGE.password.submitMsg}`);
      $select(`#${key}`).focus();
      break;
    case 'password_confirm':
      alert(`${INFO_MESSAGE.password_confirm.submitMsg}`);
      $select(`#${key}`).focus();
      break;
    case 'userName':
      alert(`${INFO_MESSAGE.userName.submitMsg}`);
      $select(`#${key}`).focus();
      break;
    case 'birthYY':
      alert(`${INFO_MESSAGE.birthYY.submitMsg}`);
      $select(`#${key}`).focus();
      break;
    case 'birthMM':
      alert(`${INFO_MESSAGE.birthMM.submitMsg}`);
      $select(`#${key}`).focus();
      break;
    case 'birthYY':
      alert(`${INFO_MESSAGE.birthYY.submitMsg}`);
      $select(`#${key}`).focus();
      break;
    case 'gender':
      alert(`${INFO_MESSAGE.gender.submitMsg}`);
      $select(`#${key}`).focus();
      break;
    case 'email':
      alert(`${INFO_MESSAGE.email.submitMsg}`);
      $select(`#${key}`).focus();
      break;
    case 'mobile':
      alert(`${INFO_MESSAGE.mobile.submitMsg}`);
      $select(`#${key}`).focus();
      break;
    case 'interest':
      alert(`${INFO_MESSAGE.interest.submitMsg}`);
      $select(`#${key}`).focus();
      break;
    case 'agree':
      alert(`${INFO_MESSAGE.agree.submitMsg}`);
      $select(`#${key}`).focus();
      break;
  }
};

export const chcekReset = () => {
  if (!confirm('초기화 하시겠습니까?')) return;
  const registerForm = $select('#registerForm');
  registerForm.reset();
  resetData(STATE_USER_DATA);
  clearTag($select('.interest-wrap'));
  console.log(STATE_USER_DATA);
};
const resetData = data => {
  for (let key in data) {
    data[key] = null;
  }
};
const resultSubmit = userData => {
  JSON_USER_DATA.userID = userData.userID;
  JSON_USER_DATA.password = userData.password;
  JSON_USER_DATA.userName = userData.userName;
  JSON_USER_DATA.birthDate = `${userData.birthYY}-${userData.birthMM}-${userData.birthDD}`;
  JSON_USER_DATA.mobile = userData.mobile;
  JSON_USER_DATA.gender = userData.gender;
  JSON_USER_DATA.interest = userData.interest;

  // const resultJSON = JSON.stringify(JSON_USER_DATA);
  registerRequest(JSON_USER_DATA)
};

const registerRequest = data => {
  const URL = 'https://cors-anywhere.herokuapp.com/https://codesquad-signup4-featureapis.herokuapp.com/api/users/create';
  fetch(URL, {
    method: 'POST',
    mode: 'cors',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(data)
  }).then((data)=>{
    console.log(data);
    console.log('회원가입 전송 완료 !')
  })
};
