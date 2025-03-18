class Apple {
    constructor() {
        this.weight = 10;
    }
    getWeight() {
        return this.weight;
    }
    isEmpty() {
        return this.weight <= 0;
    }
    decrease() {
        if (this.weight > 0) {
            this.weight--;
        }
    }
}

class Human {
    constructor(name, gender, weight) {
        this.name = name;
        this.gender = gender; // true = nam, false = nữ (tùy quy ước)
        this.weight = weight;
    }
    getName() {
        return this.name;
    }
    isMale() {
        return this.gender;
    }
    getWeight() {
        return this.weight;
    }
    say(words) {
        logMessage(this.name + " nói: " + words);
    }
    setName(name) {
        this.name = name;
    }
    setGender(gender) {
        this.gender = gender;
    }
    setWeight(weight) {
        this.weight = weight;
    }
    checkApple(apple) {
        return !apple.isEmpty();
    }
    eat(apple) {
        if (!apple.isEmpty()) {
            apple.decrease();
            this.weight++;
        }
    }
}

function runScenario() {
    clearLog();
    let apple = new Apple();
    let adam = new Human("Adam", true, 55);
    let eva = new Human("Eva", false, 50);

    while (!apple.isEmpty()) {
        if (adam.checkApple(apple)) {
            adam.eat(apple);
            logMessage(
                adam.getName() + " ăn táo: táo còn " +
                apple.getWeight() + " - " + adam.getName() +
                " nặng " + adam.getWeight()
            );
        }
        if (!apple.isEmpty() && eva.checkApple(apple)) {
            eva.eat(apple);
            logMessage(
                eva.getName() + " ăn táo: táo còn " +
                apple.getWeight() + " - " + eva.getName() +
                " nặng " + eva.getWeight()
            );
        }
    }
    adam.say("Táo đã hết rồi!");
    eva.say("Chúng ta đã ăn hết quả táo!");
}

function logMessage(msg) {
    let logArea = document.getElementById("logArea");
    logArea.textContent += msg + "\n";
}

function clearLog() {
    document.getElementById("logArea").textContent = "";
}
