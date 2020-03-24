import {
  REG_PATTERN,
  INFO_MESSAGE,
  FIELD_VALUE,
  mockData
} from "../util/constant.js";
import { $select, $selectAll, $getByID, $addListener } from "../util/func.js";
import { printMessage, addClassMessage, removeClassMessage } from './infoMessage.js'

const regEl = $select(".register");

const check = (reg, el, successMsg, errorMsg) => {
  if (reg.test(el.value)) {
    removeClassMessage(el,'error');
    return printMessage(successMsg, el);
  }
  addClassMessage(el,'error');
  printMessage(errorMsg, el);
  el.value = "";
  el.focus();
};

const changeCallback = event => {
  if (
    !check(
      REG_PATTERN.userID,
      event.target,
      INFO_MESSAGE.userID.successMsg,
      INFO_MESSAGE.userID.errorMsg
    )
  )
    return false;
};

$addListener(document, "DOMContentLoaded", () => {
  $addListener(regEl, "change", changeCallback);
});
