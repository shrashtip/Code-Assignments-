document.addEventListener('DOMContentLoaded', function () {
    const addContactBtn = document.getElementById('addContactBtn');
    const addContactForm = document.getElementById('addContactForm');
    const contactList = document.getElementById('contactList');

    addContactBtn.addEventListener('click', function () {
        addContactForm.classList.toggle('hidden');
    });

    const contactForm = document.getElementById('contactForm');
    contactForm.addEventListener('submit', function (event) {
        event.preventDefault();
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const phone = document.getElementById('phone').value;

        // Send the contact data to the server using fetch or XMLHttpRequest
        // Display the added contact on the page
        // Reset the form fields
        console.log('Name:', name);
        console.log('Email:', email);
        console.log('Phone:', phone);

        const contactItem = document.createElement('li');
        contactItem.textContent = 'Name: ${name}, Email: ${email}, Phone: ${phone}' ; 
        contactList.appendChild(contactItem);

        contactForm.reset();
        addContactForm.classList.add('hidden');
    });
});