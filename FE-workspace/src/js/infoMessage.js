export const printMessage = (msg, el, type) => {
  const element = { sibling: el.parentElement.nextElementSibling };
  switch (type) {
    case 'error':
      addClassMessage(el, type);
      el.value = '';
      el.focus();
      break;
    default:
      removeClassMessage(el, 'error');
      break;
  }
  return (element.sibling.innerHTML = msg);
};

export const addClassMessage = (el, className) => {
  const element = { sibling: el.parentElement.nextElementSibling };
  return element.sibling.classList.add(className);
};

export const removeClassMessage = (el, className) => {
  const element = { sibling: el.parentElement.nextElementSibling };
  return element.sibling.classList.remove(className);
};
