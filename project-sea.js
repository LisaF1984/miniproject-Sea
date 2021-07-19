'use strict'

const NAME = document.querySelector("#fishName");
const COLOUR = document.querySelector("#colour");
const LENGTH = document.querySelector("#lengthInches");
const COLDWATER = document.querySelector("#coldWater");

const display = document.querySelector("#display");
const DIV = document.querySelector("#responsefromdb");
let addFishButton = document.querySelector("#addFish");

const UPDATEID = document.querySelector("#updateID");
let updateBTN = document.querySelector("#updateBtn");

const REMOVEID = document.querySelector("#removeID");
let rmvBTN = document.querySelector("#rmvBtn");


const printToScreen = (name, colour, lengthInches, coldWater) => {
    const p = document.createElement("p");
    const text = document.createTextNode(`${name} ${colour} ${lengthInches} ${coldWater}`);

    p.appendChild(text);
    display.appendChild(p);
}

const createFish = (e) => {

    e.preventDefault();

    const NAME_VALUE = NAME.value;
    const COLOUR_VALUE = COLOUR.value;
    const LENGTH_VALUE = LENGTH.value;
    const COLDW_VALUE = COLDWATER.value;



    printToScreen(NAME_VALUE, COLOUR_VALUE, LENGTH_VALUE, COLDW_VALUE);
    let data = {
        name: NAME_VALUE,
        colour: COLOUR_VALUE,
        lengthInches: LENGTH_VALUE,
        coldWater: COLDW_VALUE
    }


    axios.post("http://localhost:8080/sea/create", data, {
        Headers: {
            'Access-control-allow-origin': '*',
        }
    })
        .then((response) => printToScreen("Fish created"))
        .catch((error) => console.error(error));


}

const updateFish = (e) => {
    e.preventDefault();
    const UPDATE = Number(UPDATEID.value);

    const NAME_VALUE = NAME.value;
    const COLOUR_VALUE = COLOUR.value;
    const LENGTH_VALUE = LENGTH.value;
    const COLDW_VALUE = COLDWATER.value;

    let data = {
        name: NAME_VALUE,
        colour: COLOUR_VALUE,
        lengthInches: LENGTH_VALUE,
        coldWater: COLDW_VALUE
    }
    printToScreen(NAME_VALUE, COLOUR_VALUE, LENGTH_VALUE, COLDW_VALUE);

    axios.put(`http://localhost:8080/sea/replace/${UPDATE}`,data, {
        Headers: {
            'Access-control-allow-origin': '*',
     } })
        .then((response) => printToScreen("Fish updated"))
        .catch((error) => console.error(error));
}


const removeFish = (e) => {
    e.preventDefault();
    const REMOVE = Number(REMOVEID.value);

axios.delete(`http://localhost:8080/sea/delete/${REMOVE}`, {
    Headers: {
        'Access-control-allow-origin': '*',
    }
})
    .then((response) => printToScreen("Fish removed"))
    .catch((error) => console.error(error));

}
const readFish = (e) => {
    e.preventDefault();

    let data = {
        name: NAME_VALUE,
        colour: COLOUR_VALUE,
        lengthInches: LENGTH_VALUE,
        coldWater: COLDW_VALUE
    }

    axios.get("http://localhost:8080/sea/read", data, {
    Headers: { 
        'Access-control-allow-origin': '*',
    }})
    .then((response) => printToScreen("list"))
    .catch((error) => console.error(error))




addFishButton.addEventListener('click', createFish);
updateBTN.addEventListener(`click`, updateFish);
rmvBTN.addEventListener('click', removeFish);

// axios.post("http://localhost:9092/sea/create")

}