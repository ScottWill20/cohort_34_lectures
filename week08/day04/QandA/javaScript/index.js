// variables 
// var varTest = 'testing my var';
// // var can be redecleared 
// var varTest = 'something else';
// // var can be reassigned / update
// varTest = 'another thing';
// // var is function scoped - we will talk about this in a second 
// console.log(varTest);

// let cannot be redeclared
// can be updated 
// block scoped 
// let letTest = 'testing my let';
// //let letTest = 'some other thing';
// letTest = 'some other value';
// console.log(letTest);

// const can not redeclare 
// cannot update 
// block scoped 
// const constTest = 'testing my const';
// constTest = 'something else';
// console.log(constTest);

// Which one should I use? use const until you can't and then use let but avoid var 

//block scoped 

// {
//     let myName = 'Brit';
// }
// console.log(myName);

// function scoped 
// function stopVar(){
//     var letMeEscape = 'I want out!!!';
//     return letMeEscape;
// }
// console.log(stopVar());

// let charA = 'a';

// console.log(typeof charA);

// functions 

// function declaration 
// console.log(add(1, 2)); // 3
// console.log(add('hello ', 'world')); // hello world 

// function add(num1, num2){
//     return num1 + num2; 
// }
// console.log(add(1, 2)); // 3
// console.log(add('hello ', 'world')); // hello world 

// // it's one of the two things in javaScript that hoisted 
// // hoisting only works with function declarations and variable declearations using var
// console.log(myName);
// var myName = 'Brit';
// console.log(myName);

// function expression NOT HOISTED 
// const add = function(num1, num2){
//     return num1 + num2; 
// }

// console.log(add(1, 2)); // 3
// console.log(add('hello ', 'world')); // hello world 

// arrow functions - syntacical sugar 
// const add = (num1, num2) => num1 + num2;

// console.log(add(1, 2)); // 3
// console.log(add('hello ', 'world')); // hello world 

// ARROW FUNCTION NO NOs - working with objects - or events 

// loops 

// for(let i = 0; i < 5; i++){
//     console.log(i);
// }

// // conditionals 
// if(5 < 3){
//     console.log('its true');
// }else if(5 == 3){
//     console.log('running else if');
// }else { // else doesn't get a condition - its default - do this if nothing else is true
//     console.log('both of the above statements are not true');
// }

// difference between console.log and return 
// console.log === System.out.println - it prints a value to our console 
// return - can only be used inside of function - and it gives us something back from the function

//console.log(functionName());

// arrays
// const cities = ['Tel Aviv', 'Cape Town', 'New York', 'Kigali', 'Istanbul', 'Lisbon'];
// // console.log(cities[0]); // give me Tel Aviv 
// // console.log(cities.length);
// // console.log(cities[cities.length -1]); // always return the very last item in an array 
// // console.log(cities[7]);

// // add a city to the beginning of an array 
// cities.unshift('Tblisi');

// console.log(cities);

// // add items to end of an array 
// cities.push('Tehran');
// console.log(cities);

// // remove items from the beginning 
// cities.shift(); 
// console.log(cities);

// // remove an item from the end 
// cities.pop();
// console.log(cities);

// // delete a city at a different index 
// cities.splice(2,1);

// console.log(cities);

// // adding at a specific index 
// cities.splice(3, 0, 'Boston');
// // splice(index, delete count, item to add);
// console.log(cities);

// objects 

// const dog = {
//     //key: value,
//     name: 'Ada',
//     breed: 'Bali Dog',
//     age: 5, 
//     colour: 'brindle',
//     favFood: 'Salmon',
//     // methods - which are functions that belong to objects 
//     eat: function(){
//         return `${this.name} is a ${this.breed} and her favourite food is ${this.favFood}`;
//     }
// }

// // dot notation 
// console.log(dog.eat());
// console.log(dog.name);

// const dog = {
//     //key: value,
//     "name": 'Ada',
//     "breed": 'Bali Dog',
//     "age": 5, 
//     "colour": 'brindle',
//     "fav Food": 'Salmon',
//     // methods - which are functions that belong to objects 
//     "eat": function(){
//         return `${this.name} is a ${this.breed} and her favourite food is ${this["fav Food"]}`;
//     }
// }
//  console.log(dog.name);
//  //bracket notation 
//  console.log(dog['fav Food']);
// console.log(dog.eat());

// advanced array methods 
const cityData = [
    {"city": "Tel Aviv", "country": "Israel", "population": 435855, "land_area": 52},
    {"city": "Cape Town", "country": "South Africa", "population": 4618000, "land_area": 2446},
    {"city": "Kigali", "country": "Rwanda", "population": 859332, "land_area": 730},
    {"city": "New York", "country": "USA", "population": 8380000, "land_area": 784}  
];
// forEach
// does not return a new array automatically 
// must iterate through every single item in the array without stopping 
// does not need a return statement 
// const lowerCaseCityNames = [];
// cityData.forEach(function(item){
//     lowerCaseCityNames.push(item.city.toLowerCase());
// });
// console.log(lowerCaseCityNames);

// arrow function syntax 
// const lowerCaseCityNames = [];
// cityData.forEach(item => lowerCaseCityNames.push(item.city.toLowerCase()));
// console.log(lowerCaseCityNames);

// map
// returns a new array automatically 
// return is needed 
// what gets returned to the new array comes after the return statement 
// used for converting data 
// const lowerCaseCityNames = cityData.map(function(item){
//     return item.city.toLowerCase(); // what comes after the return gets pushed to my new array
// });
// console.log(lowerCaseCityNames);

// const lowerCaseCityNames = cityData.map(item => item.city.toLowerCase());
// console.log(lowerCaseCityNames);

//.filter 
// return a new array 
// filters things based on a boolean 
// if it's true it's included if it's false it's excluded 

// const bigPops = cityData.filter(function(city){
//     return city.population > 4000000;
// });
// console.log(bigPops);

// const bigPops = cityData.filter(city => city.population > 4000000);
// console.log(bigPops);

// callbacks
// Higher order functions are functions that take other functions as an argument 
// callback function is a function that is passed into another function as an argument 
// HOF 
function kitchen(ing1, ing2, chefcb){
    return chefcb(ing1, ing2);
}

// callback functions 
function pizzaChef(ing1, ing2){
    return `I took ${ing1} and ${ing2} and I made you a 🍕 🧑‍🍳`;
}

function pastaChef(ing1, ing2){
    return `I took ${ing1} and ${ing2} and I made you a 🍝 🧑‍🍳`;
}

console.log(kitchen('sauce', 'dough', pizzaChef));
console.log(kitchen('sauce', 'dough', pastaChef));
// promises 


// async await 


// fetch 


