const tags = [];
export const addInterest = (event, tagContainer) => {
  const target = event.target;
  if (event.key !== ',') return;
  tags.push(target.value.replace(/[,]/g, ''));
  target.value = '';
  resetTag();
  tags
    .slice()
    .reverse()
    .forEach(tag => {
      const input = addTag(tag);
      tagContainer.prepend(input);
    });
};

const addTag = label => {
  const tag = document.createElement('span');
  tag.setAttribute('class', 'tag');
  tag.innerHTML = `${label}<span id="tag-close" class="material-icons" data-item="${label}">highlight_off</span>`;
  return tag;
};

export function resetTag() {
  document.querySelectorAll('.tag').forEach(tag => tag.parentElement.removeChild(tag));
}

export const removeTag = (event, tagContainer) => {
  const target = event.target;

  const data = target.getAttribute('data-item');
  const index = tags.indexOf(data);
  tags.splice(index, 1);
  resetTag();
  tags
    .slice()
    .reverse()
    .forEach(tag => {
      const input = addTag(tag);
      tagContainer.prepend(input);
    });
};
