document.getElementById('profile').onclick = function () {
    location.href='/profile/lolo'
};

document.getElementById('logo').onclick = function () {
    location.href='/'
};


document.querySelectorAll('.side-menu-element').forEach(function(element) {
    element.addEventListener('click', function() {
        let link = this.querySelector('a');
        window.location.href = link.getAttribute('href');
    });
});

document.getElementById('menu').addEventListener('click', function() {
    document.getElementById('side-menu').classList.add('open-menu');
});

document.getElementById('close-menu').addEventListener('click', function() {
    document.getElementById('side-menu').classList.remove('open-menu');
});

function changeLanguage(language) {
    console.log("Changing language to:", language);
    document.getElementById('selected-lang').textContent = language.toUpperCase();
    document.cookie = "lang=" + language + ";path=/";
    closeDropdown();
    window.location.href = window.location.pathname + '?lang=' + language;
}

function closeDropdown() {
    let dropdown = document.querySelector('.language-dropdown .dropdown');
    dropdown.style.display = 'none';
}

function getCookie(name) {
    let matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}

function setLanguageFromStorage() {
    let lang = getCookie("lang");
    if (lang) {
        document.getElementById('selected-lang').textContent = lang.toUpperCase();
    }
}

document.getElementById('selected-language').addEventListener('click', function(event) {
    event.stopPropagation();
    let dropdown = document.querySelector('.language-dropdown .dropdown');
    dropdown.style.display = dropdown.style.display === 'block' ? 'none' : 'block';
});

document.addEventListener('click', closeDropdown);

window.addEventListener('load', setLanguageFromStorage);
