import { REG_PATTERN, INFO_MESSAGE, MIN_AGE, MAX_AGE, mockData } from '../util/constant.js';
import { $select, $addListener } from '../util/func.js';
import { printMessage } from './infoMessage.js';
import { birthRender, dayRender } from './birthRender.js';
// import { addInterests } from './interest.js'

const stateBirth = {
  selectYear: null,
  selectMonth: null
};
const elementRegister = $select('.register');
const [elementYY, elementMM, elementDD] = [$select('#birthYY'), $select('#birthMM'), $select('#birthDD')];

const checkID = (id, target) => {
  const ERROR = 'error';
  const REG = REG_PATTERN.userID;
  const MESSAGE = INFO_MESSAGE.userID;
  if (!REG.test(id)) return printMessage(MESSAGE.errorMsg, target, ERROR);
  return printMessage(MESSAGE.successMsg, target);
};

const checkPW = (password, target) => {
  const ERROR = 'error';
  const REG = REG_PATTERN.password;
  const MESSAGE = INFO_MESSAGE.password;
  const MESSAGE_ERROR = MESSAGE.errorMsg;
  if (!REG.limit.test(password)) return printMessage(MESSAGE_ERROR.limit, target, ERROR);
  if (!REG.case.test(password)) return printMessage(MESSAGE_ERROR.case, target, ERROR);
  if (!REG.number.test(password)) return printMessage(MESSAGE_ERROR.number, target, ERROR);
  if (!REG.symbol.test(password)) return printMessage(MESSAGE_ERROR.symbol, target, ERROR);
  return printMessage(MESSAGE.successMsg, target);
};

const checkReconfirm = (checkValue, originalValue, target) => {
  const ERROR = 'error';
  const MESSAGE = INFO_MESSAGE.password_confirm;
  if (originalValue !== checkValue) return printMessage(MESSAGE.errorMsg, target, ERROR);
  return printMessage(MESSAGE.successMsg, target);
};

const checkEmail = (email, target) => {
  const ERROR = 'error';
  const REG = REG_PATTERN.email;
  const MESSAGE = INFO_MESSAGE.email;
  const MESSAGE_ERROR = MESSAGE.errorMsg;
  if (!REG.test(email)) return printMessage(MESSAGE_ERROR, target, ERROR);
  return printMessage(MESSAGE.successMsg, target);
};

const checkBirth = () => {};

const checkMobile = (mobile, target) => {
  const ERROR = 'error';
  const REG = REG_PATTERN.mobile;
  const MESSAGE = INFO_MESSAGE.mobile;
  const MESSAGE_ERROR = MESSAGE.errorMsg;
  if (!REG.test(mobile)) return printMessage(MESSAGE_ERROR, target, ERROR);
  return printMessage(MESSAGE.successMsg, target);
};

const checkInterest = () => {};

const changeCallback = event => {
  const target = event.target;
  switch (event.target.id) {
    case 'userID':
      checkID(target.value, target);
      break;
    case 'password':
      checkPW(target.value, target);
      break;
    case 'password_confirm':
      checkReconfirm(target.value, $select('#password').value, target);
      break;
    case 'birthYY':
      stateBirth.selectYear = target.options[target.selectedIndex].value;
      dayRender(stateBirth.selectYear, stateBirth.selectMonth, elementDD);
      break;
    case 'birthMM':
      stateBirth.selectMonth = target.options[target.selectedIndex].value;
      dayRender(stateBirth.selectYear, stateBirth.selectMonth, elementDD);
      break;
    case 'birthDD':
      console.log(stateBirth);
      break;
    case 'email':
      checkEmail(target.value, target);
      break;
    case 'mobile':
      checkMobile(target.value, target);
      break;
    case 'interest':
      // addInterests()
      break;
    default:
      break;
  }
};

$addListener(document, 'DOMContentLoaded', () => {
  birthRender(MIN_AGE, MAX_AGE, elementYY, elementMM, elementDD);
  $addListener(elementRegister, 'change', changeCallback);
});
