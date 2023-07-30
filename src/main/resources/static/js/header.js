document.getElementById('profile').onclick = function () {
    location.href='/profile/lolo'
};
document.getElementById('profileSettings').onclick = showSettings;

document.getElementById('menu').onclick = showMenu;

document.getElementById('logo').onclick = function () {
    location.href='/'
};

function showMenu() {
    console.log("menu");
}

function showSettings() {
    console.log("settings");
}


function changeLanguage(language) {
    document.getElementById('selected-lang').innerText = language.toUpperCase();
    localStorage.setItem('selectedLanguage', language);
    closeDropdown();
    window.location.href = window.location.pathname + '?lang=' + language;
}

function closeDropdown() {
    var dropdown = document.querySelector('.language-dropdown .dropdown');
    dropdown.style.display = 'none';
}

function setLanguageFromStorage() {
    var savedLanguage = localStorage.getItem('selectedLanguage');
    if (savedLanguage) {
        document.getElementById('selected-lang').innerText = savedLanguage.toUpperCase();
    }
}

document.getElementById('selected-language').addEventListener('click', function(event) {
    event.stopPropagation();
    var dropdown = document.querySelector('.language-dropdown .dropdown');
    dropdown.style.display = dropdown.style.display === 'block' ? 'none' : 'block';
});

document.addEventListener('click', closeDropdown);

window.addEventListener('load', setLanguageFromStorage);


