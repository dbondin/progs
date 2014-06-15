var mainDiv = null;
var pageDiv = null;
var headDiv = null;
var pageNo = null;
var titleDiv = null;
var pagesSelect = null;
var pagesOptions = null;
var firstButton = null;
var prevButton = null;
var nextButton = null
var lastButton = null;
var countSpan = null;

function init() {
  pageDiv = document.getElementById('page');
  if(pageDiv == null) {
    return;
  }
  mainDiv = document.getElementById('main');
  headDiv = document.getElementById('head');
  titleDiv = document.getElementById('title');
  pagesSelect = document.getElementById('pages');
  firstButton = document.getElementById('first');
  prevButton = document.getElementById('prev');
  nextButton = document.getElementById('next');
  lastButton = document.getElementById('last');
  countSpan = document.getElementById('count');

  pageNo = 1;

  titleDiv.innerHTML = book.title + ' / ' + book.author;
  countSpan.innerHTML = 'of ' + book.pages;

  pagesOptions = new Array();

  for(i=1; i<=book.pages; i++) {
    pagesOptions[i] = new Option('Page ' + i, i, i);
    pagesSelect.options[pagesSelect.options.length] = pagesOptions[i];
  }

  applyPage(pageNo);
  fixSize();
}

function applyPage(n) {
  pageDiv.innerHTML='<img class="pageimg" src="/preview/' + book.id + '/' + n + '"/>';
  if(pagesOptions[n].selected != true) {
    pagesOptions[n].selected = true;
  }
  firstButton.disabled = (n == 1);
  prevButton.disabled = (n == 1);
  nextButton.disabled = (n == book.pages);
  lastButton.disabled = (n == book.pages);

}

function next() {
  if(pageDiv == null) {
    return;
  }
  if(pageNo == book.pages) {
    return;
  }
  pageNo++;
  applyPage(pageNo);
}

function last() {
  if(pageDiv == null) {
    return;
  }
  if(pageNo == book.pages) {
    return;
  }
  pageNo = book.pages;
  applyPage(pageNo);
}

function prev() {
  if(pageDiv == null) {
    return;
  }
  if(pageNo == 1) {
    return;
  }
  pageNo--;
  applyPage(pageNo);
}

function first() {
  if(pageDiv == null) {
    return;
  }
  if(pageNo == 1) {
    return;
  }
  pageNo = 1;
  applyPage(pageNo);
}

function fixSize() {

  if(pageDiv == null) {
    return;
  }

  var h = mainDiv.offsetHeight - headDiv.offsetHeight;

  pageDiv.style.height = '' + h + 'px';
}

function select() {
  if(pagesSelect.selectedIndex < 0) {
    return;
  }

  pageNo = pagesSelect.options[pagesSelect.selectedIndex].value;
  applyPage(pagesSelect.options[pagesSelect.selectedIndex].value);
}
