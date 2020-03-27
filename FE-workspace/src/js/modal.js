import { PRIVACY_CONTENTS } from '../util/constant.js';
import { STATE_USER_DATA } from './registerUserData.js';

const modalLink = document.querySelector('#modal-link');
const modalWrap = document.querySelector('#modal');
const modalClose = document.querySelector('.modal-close');
const modalContents = document.querySelector('.modal-contents');
const modalBtn = document.querySelector('.btn-agree');

export const modal = () => {
  modalRender(modalContents);
  // btnActivated();
  modalLink.addEventListener('click', e => {
    e.preventDefault();
    modalWrap.classList.add('active');
  });
  modalClose.addEventListener('click', () => {
    modalWrap.classList.remove('active');
  });
  modalBtn.addEventListener('click', agreeActivated);
  modalContents.addEventListener('scroll', btnActivated);
};

const modalRender = target => {
  target.innerHTML = PRIVACY_CONTENTS;
};
const btnActivated = () => {
  if (modalContents.clientHeight + modalContents.scrollTop >= modalContents.scrollHeight) return;
  // 스크롤 이후 버튼 + 체크박스 엑티브 추가
  // 버튼은 disabled = false
  modalBtn.disabled = false;
};
const agreeActivated = () => {
  modalWrap.classList.remove('active');
  document.querySelector('#agree').checked = true;
  STATE_USER_DATA.agree = true;
}