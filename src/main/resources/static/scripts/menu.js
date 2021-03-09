function menuActive() {
    let menuToggle = document.querySelector('#menu-toggle');
    let sideBar = document.querySelector('#sidebar');
    let closeMenu = document.querySelector('.content')
    menuToggle.addEventListener('click', () => {
        sideBar.classList.add('visible-menu')
    })

    closeMenu.addEventListener('click', () => {
        sideBar.classList.remove('visible-menu')
        menuToggle.classList.remove('x-animation')
    })
    menuToggle.addEventListener('click', () => {
        menuToggle.classList.toggle('x-animation')
    })
}

menuActive()

