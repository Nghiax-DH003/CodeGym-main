function Hero(image, top, left, size, speed) {
  this.image = image;
  this.top = top;
  this.left = left;
  this.size = size;
  this.speed = speed;

  this.getHeroElement = function() {
    return '<img width="'+ this.size + '"' +
        ' height="'+ this.size + '"' +
        ' src="' + this.image + '"' +
        ' style="position:absolute; top:'+ this.top +'px; left:'+ this.left +'px;" />';
  }

  this.moveRight = function() {
    this.left += this.speed;
  }
  this.moveLeft = function() {
    this.left -= this.speed;
  }
  this.moveUp = function() {
    this.top -= this.speed;
  }
  this.moveDown = function() {
    this.top += this.speed;
  }
}

var hero = new Hero('ll.png', 20, 30, 200, 20);

function drawHero() {
  document.getElementById('game').innerHTML = hero.getHeroElement();
}

// Vẽ lần đầu
drawHero();

// Sự kiện phím
document.addEventListener('keydown', function(e) {
  switch(e.key) {
    case 'ArrowRight':
      hero.moveRight();
      break;
    case 'ArrowLeft':
      hero.moveLeft();
      break;
    case 'ArrowUp':
      hero.moveUp();
      break;
    case 'ArrowDown':
      hero.moveDown();
      break;
  }
  drawHero();
});
