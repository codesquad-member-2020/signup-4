import {MIN_AGE} from '../util/constant.js';

export const calcBirth = (min, max) => {
  const date = new Date();
  const year = date.getFullYear();
  const minAge = year - min;
  const maxAge = year - max;
  const rangeYear = minAge - maxAge;
  const yearList = [...Array(rangeYear).keys()].map(i => i + (year - max)).reverse();
  const monthList = [...Array(12).keys()].map(i => i + 1);
  return [yearList, monthList];
};

export const yearRender = (year, target) => {
  const yearList = year;
  const renderYear = yearList.reduce((acc, cur) => {
    return (acc += `<option value="${cur}">${cur}</option>`);
  }, `<option value="">년(만${MIN_AGE}세 이상)</option>`);
  return (target.innerHTML = renderYear);
};

export const monthRender = (month, target) => {
  const monthList = [...month];
  const renderMonth = monthList.reduce((acc, cur) => {
    return (acc += `<option value="${cur}">${cur}</option>`);
  }, `<option value="">월</option>`);
  return (target.innerHTML = renderMonth);
};

export const dayRender = (year, month, target) => {
  const day = new Date(year, month, 0).getDate();
  const dayList = [...Array(day).keys()].map(i => i + 1);
  const renderDay = dayList.reduce((acc, cur) => {
    return (acc += `<option value="${cur}">${cur}</option>`);
  }, `<option>일</option>`);
  return (target.innerHTML = renderDay);
};
