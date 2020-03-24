import {
  REG_PATTERN,
  INFO_MESSAGE,
  FIELD_VALUE,
  mockData
} from "../util/constant.js";
import { $select, $selectAll, $getByID, $addListener } from "../util/func.js";
import {
  printMessage,
  addClassMessage,
  removeClassMessage
} from "./infoMessage.js";

const regEl = $select(".register");

// 상수를 사용하여도 순수함수가 될 수 있다. 상수는 변화가 없기 때문에..
const check = (reg, el, successMsg, errorMsg) => {
  if (reg.test(el.value)) {
    removeClassMessage(el, "error");
    return printMessage(successMsg, el);
  }
  addClassMessage(el, "error");
  printMessage(errorMsg, el);
  el.value = "";
  el.focus();
};

const changeCallback = event => {
  switch (event.target.id) {
    case "userID":
      if (!check(REG_PATTERN.userID,event.target,INFO_MESSAGE.userID.successMsg,INFO_MESSAGE.userID.errorMsg)) return false;
      break;
    case "password":
      if (!check(REG_PATTERN.password,event.target,INFO_MESSAGE.password.successMsg,INFO_MESSAGE.password.errorMsg.limit)) return false;
      break;
    case "password_confirm":
      if (!check(REG_PATTERN.password,event.target,INFO_MESSAGE.password.successMsg,INFO_MESSAGE.password.errorMsg.limit)) return false;
      break;
    case "birthYY":
      console.log('YY')
      break;
    case "birthMM":
      console.log('MM')
      break;
    case "birthDD":
      console.log('DD')
      break;
    case "email":
      console.log('email')
      break;
    case "mobile":
      console.log('mobile')
      break;
    case "interest":
      console.log('관심사')
      break;
    default:
      break;
  }
  // if (
  //   !check(
  //     REG_PATTERN.userID,
  //     event.target,
  //     INFO_MESSAGE.userID.successMsg,
  //     INFO_MESSAGE.userID.errorMsg
  //   )
  // )
  //   return false;
};

$addListener(document, "DOMContentLoaded", () => {
  $addListener(regEl, "change", changeCallback);
});
