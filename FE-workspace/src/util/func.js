export const $select = el => document.querySelector(el);
export const $selectAll = el => document.querySelectorAll(el);
export const $getByID = el => document.getElementById(el);
export const $addListener = (target, type, callback) => target.addEventListener(type, callback);