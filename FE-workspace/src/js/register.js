import { REG_PATTERN, INFO_MESSAGE, MIN_AGE, MAX_AGE, mockData } from '../util/constant.js';
import { $select, $addListener } from '../util/func.js';
import { STATE_USER_DATA } from './registerUserData.js';
import { checkID, checkPW, checkPWReconfirm, checkEmail, checkBirth, checkMobile, checkInterest, checkSubmit } from './registerCheck.js';
import { calcBirth, yearRender, monthRender, dayRender } from './registerBirthRender.js';
import { addInterest, removeTag } from './registerInterest.js';

const elementRegister = $select('.register');
const elementRegisterBtns = $select('.btn-wrap');
const elementInterestBox = $select('.interest-box');
const [elementYY, elementMM, elementDD] = [$select('#birthYY'), $select('#birthMM'), $select('#birthDD')];
const [calcYear, calcMonth] = calcBirth(MIN_AGE, MAX_AGE);

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
      checkPWReconfirm(target.value, $select('#password').value, target);
      break;
    case 'userName':
      STATE_USER_DATA.userName = target.value;
      break;
    case 'birthYY':
      STATE_USER_DATA.birthYY = target.options[target.selectedIndex].value;
      dayRender(STATE_USER_DATA.birthYY, STATE_USER_DATA.birthMM, elementDD);
      break;
    case 'birthMM':
      STATE_USER_DATA.birthMM = target.options[target.selectedIndex].value;
      dayRender(STATE_USER_DATA.birthYY, STATE_USER_DATA.birthMM, elementDD);
      break;
    case 'birthDD':
      STATE_USER_DATA.birthDD = target.value;
      break;
    case 'gender':
      STATE_USER_DATA.gender = target.value;
      break;
    case 'email':
      checkEmail(target.value, target);
      break;
    case 'mobile':
      checkMobile(target.value, target);
      break;
  }
};

const clickCallback = event => {
  event.preventDefault();
  const target = event.target;
  console.log(target.id);
  switch (target.id) {
    case 'reset':
      // 초기화 확인창 승인 => .reset() + STATE_USER_DATA도 초기화;
      console.log('reset');
      break;
    case 'submit':
      checkSubmit(STATE_USER_DATA);
      break;
  }
};
const interestCallback = event => {
  if (event.target.id === 'tag-close') return removeTag(event, $select('.interest-box'));
};

const keydownCallback = event => {
  addInterest(event, $select('.interest-box'));
};

$addListener(document, 'DOMContentLoaded', () => {
  yearRender(calcYear, elementYY);
  monthRender(calcMonth, elementMM);
  $addListener(elementRegister, 'change', changeCallback);
  $addListener(elementRegisterBtns, 'click', clickCallback);
  $addListener(elementRegister, 'keyup', keydownCallback);
  $addListener(elementInterestBox, 'click', interestCallback);
});
