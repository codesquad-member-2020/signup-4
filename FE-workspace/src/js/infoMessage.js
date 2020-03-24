export const printMessage = (msg, el) => {
  const element = { sibling: el.parentElement.nextElementSibling };
  return (element.sibling.innerHTML = msg);
}

export const addClassMessage = (el, className) => {
  const element = { sibling: el.parentElement.nextElementSibling };
  return element.sibling.classList.add(className);
}

export const removeClassMessage = (el, className) => {
  const element = { sibling: el.parentElement.nextElementSibling };
  return element.sibling.classList.remove(className);
}
