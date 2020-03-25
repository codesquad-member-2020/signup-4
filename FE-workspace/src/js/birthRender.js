export const birthRender = (min, max, ...target) => {
  const [targetYear, targetMonth] = target;
  const date = new Date();
  const year = date.getFullYear();

  const minAge = year - min;
  const maxAge = year - max;

  const rangeYear = minAge - maxAge;

  const yearList = [...Array(rangeYear).keys()].map(i => i + (year - max)).reverse();
  const monthList = [...Array(12).keys()].map(i => i + 1);

  const renderYear = yearList.reduce((acc, cur) => {
    return (acc += `<option value="${cur}">${cur}</option>`);
  }, `<option value="">년(만${min}세 이상)</option>`);

  const renderMonth = monthList.reduce((acc, cur) => {
    return (acc += `<option value="${cur}">${cur}</option>`);
  }, `<option value="">월</option>`);

  return (targetYear.innerHTML = renderYear), (targetMonth.innerHTML = renderMonth);
};

export const dayRender = (year, month, target) => {
  const day = new Date(year,month,0).getDate()
  const dayList = [...Array(day).keys()].map(i => i + 1);
  const renderDay = dayList.reduce((acc, cur) => {
    return (acc += `<option value="${cur}">${cur}</option>`);
  }, `<option>월</option>`);
  return target.innerHTML = renderDay
} 