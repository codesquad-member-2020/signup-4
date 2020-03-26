export const modal = () => {
  const a = document.querySelector('#modal-link');
  const modal = document.querySelector('#modal');
  const modalClose = document.querySelector('.modal-close');
  a.addEventListener('click', (e)=>{
    e.preventDefault();
    modal.classList.add('active');
  })
  modalClose.addEventListener('click', ()=>{
    modal.classList.remove('active');
  })
};
