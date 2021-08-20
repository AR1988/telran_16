document.addEventListener('DOMContentLoaded', function () {
    const contactWrapperDOM = document.querySelector("#contact-wrapper");
    const contactTemplateDOM = document.querySelector("#contact-template");

    const contactFormDOM = document.querySelector("#contact-form");
    const searchFormDOM = document.querySelector("#search-form");

    const contactRenderer = new ContactRenderer(contactWrapperDOM, contactTemplateDOM, contactFormDOM);

    const contactService = new ContactService(contactRenderer);

    const contactFormListener = new ContactFormListener(contactFormDOM, contactService);
    const contactWrapperListener = new ContactWrapperListener(contactService);
    const searchFormListener = new SearchFormListener(contactService, searchFormDOM);


    contactFormDOM.addEventListener('click', contactFormListener);
    contactWrapperDOM.addEventListener('click', contactWrapperListener);
    searchFormDOM.addEventListener('click', searchFormListener);
});

class SearchFormListener {
    constructor(contactService, searchFormDOM) {
        this.contactService = contactService;
        this.searchFormDOM = searchFormDOM;
    }

    handleEvent(event) {
        const aElementDom = event.target.closest("a");

        if (aElementDom !== null) {
            const action = aElementDom.dataset.action;
            this[action](event);
        }
    }

    search(event) {
        const searchDom = event.currentTarget;
        const searchTerm = searchDom.elements.searchName.value;

        this.contactService.filter(searchTerm.toLowerCase());
    }

    reset(event) {
        this.searchFormDOM.reset();
        this.contactService.reloadAll();
    }
}

class ContactWrapperListener {
    constructor(contactService) {
        this.contactService = contactService;
    }

    handleEvent(event) {
        const aElementDom = event.target.closest("a");
        if (aElementDom != null) {
            this[aElementDom.dataset.action](event);
        }
    }

    toggle(event) {
        const contactDom = event.target.closest("li");
        console.log(contactDom);
        this.contactService.toggleDetails(contactDom);
    }

    edit(event) {
        const contact = this._getContact(event);
        this.contactService.startEdit(contact)
    }

    remove(event) {
        const contact = this._getContact(event);
        this.contactService.remove(contact);
    }

    _getContact(event) {
        // const domElement = event.target.closest("li");
        // const contact = domElement.contact;
        // return contact;
        return event.target.closest("li").contact;
    }
}

class ContactFormListener {

    constructor(contactFormDOM, contactService) {
        this.contactFormDOM = contactFormDOM;
        this.contactService = contactService;
    }

    handleEvent(event) {
        const aElementDom = event.target.closest("a");

        if (aElementDom !== null) {
            // if (aElementDom.dataset.action === "add")
            //     this.add();
            //     this["add"]();
            // else if (aElementDom.dataset.action === "save")
            //     this.save();
            //     this["save"]();
            // else if (aElementDom.dataset.action === "cancel")
            //     this.cancel();
            //     this["cancel"]();
            const action = aElementDom.dataset.action;
            this[action](event);
        }
    }

    add(event) {
        const contactForm = event.currentTarget;
        const contact = {
            firstName: contactForm.elements.firstName.value,
            lastName: contactForm.elements.lastName.value,
            age: contactForm.elements.age.value,
        }

        this.contactService.add(contact);

        this.contactFormDOM.elements.firstName.value = "";
        this.contactFormDOM.elements.lastName.value = "";
        this.contactFormDOM.elements.age.value = "";
        this.contactFormDOM.reset();
    }

    save(event) {
        const contactForm = event.currentTarget;
        const contact = {
            firstName: contactForm.elements.firstName.value,
            lastName: contactForm.elements.lastName.value,
            age: contactForm.elements.age.value,
            id: +contactForm.elements.id.value
        }
        this.contactService.completeEdit(contact);
    }

    cancel(event) {
        this.contactService.cancelEdit();
    }
}

class ContactRenderer {

    constructor(contactWrapperDOM, contactTemplateDOM, contactFormDOM) {
        this.contactWrapperDOM = contactWrapperDOM;
        this.contactTemplateDOM = contactTemplateDOM;
        this.contactFormDOM = contactFormDOM;

        this.addButtonDom = this.contactFormDOM.querySelector('a[data-action="add"]');
        this.editButtonDom = this.contactFormDOM.querySelector('a[data-action="save"]');
        this.cancelButtonDom = this.contactFormDOM.querySelector('a[data-action="cancel"]');
    }

    _renderContact(contact) {
        const newNode = this.contactTemplateDOM.cloneNode(true);

        newNode.contact = contact;

        newNode.querySelector('span[data-id="name"]').innerHTML = contact.firstName;
        newNode.querySelector('span[data-id="lastname"]').innerHTML = contact.lastName;
        newNode.classList.toggle("hide-element");
        // newNode.setAttribute("id", 'contact-' + contact.id);
        newNode.setAttribute("id", `contact-${contact.id}`);

        //contact details
        const contactDetailsNode = document.querySelector("#contact-details-template").cloneNode(true);
        contactDetailsNode.removeAttribute("id");
        contactDetailsNode.querySelector('span[data-id="name"]').innerHTML = contact.firstName;
        contactDetailsNode.querySelector('span[data-id="lastName"]').innerHTML = contact.lastName;
        contactDetailsNode.querySelector('span[data-id="age"]').innerHTML = contact.age;
        newNode.append(contactDetailsNode);
        //
        this.contactWrapperDOM.append(newNode);
    }

    renderContacts(contacts) {
        for (const contact of contacts) {
            this._renderContact(contact);
        }
    }

    toEditForm(contact) {
        this.addButtonDom.classList.add("hide-element");
        this.editButtonDom.classList.remove('hide-element');
        this.cancelButtonDom.classList.remove('hide-element');

        this.contactFormDOM.elements.firstName.value = contact.firstName;
        this.contactFormDOM.elements.lastName.value = contact.lastName;
        // this.contactFormDOM.elements.lastName.setAttribute("value", contact.lastName);
        this.contactFormDOM.elements.age.value = contact.age;
        this.contactFormDOM.elements.id.value = contact.id;
    }

    toAddForm() {
        this.addButtonDom.classList.remove("hide-element");
        this.editButtonDom.classList.add('hide-element');
        this.cancelButtonDom.classList.add('hide-element');

        this.contactFormDOM.elements.firstName.value = "";
        this.contactFormDOM.elements.lastName.value = "";
        // this.contactFormDOM.elements.lastName.setAttribute("value", "");
        this.contactFormDOM.elements.age.value = "";
        this.contactFormDOM.reset();
    }

    clearAll() {
        const liHeader = this.contactWrapperDOM.querySelector(".collection-header");
        this.contactWrapperDOM.innerHTML = "";
        this.contactWrapperDOM.append(liHeader);
    }

    toggleContactDetails(contactDom) {
        contactDom.querySelector(".contact-item-details")
            .classList.toggle("hide-element");
    }
}

class ContactService {

    fakeContacts = [
        {firstName: "Max", lastName: "Mustermann", age: 25, id: 1},
        {firstName: "Vasja", lastName: "Pupkin", age: 18, id: 2},
        {firstName: "John", lastName: "Doe", age: 35, id: 3},
        {firstName: "Mark", lastName: "Schmidt", age: 43, id: 4},
        {firstName: "Anna", lastName: "Baumann", age: 34, id: 5}
    ];

    constructor(contactRenderer) {
        this.contactRenderer = contactRenderer;

        this.getAll();
    }

    getAll() {
        this.contactRenderer.renderContacts(this.fakeContacts);
    }

    remove(contact) {
        // const index = this.fakeContacts.findIndex(value => value.id === contact.id);
        const index = this.fakeContacts.indexOf(contact);

        if (index >= 0) {
            this.fakeContacts.splice(index, 1);
            this.reloadAll();
        }
    }

    add(contact) {
        const lastIndex = this.fakeContacts[this.fakeContacts.length - 1].id;
        contact.id = lastIndex + 1;
        this.fakeContacts.push(contact);

        // this.contactRenderer.renderContacts([contact]);

        this.reloadAll();
    }

    toggleDetails(contactDom) {
        this.contactRenderer.toggleContactDetails(contactDom);
    }

    startEdit(contact) {
        this.contactRenderer.toEditForm(contact);
    }

    completeEdit(contact) {
        if (contact.id === 0)
            console.log("Entity not found")

        const index = this.fakeContacts.findIndex(value => value.id === contact.id);
        if (index > -1) {
            this.fakeContacts[index] = contact;
            this.reloadAll();

            this.contactRenderer.toAddForm();
        } else {
            console.log("Element not found");
        }
    }

    cancelEdit() {
        this.contactRenderer.toAddForm();
    }

    filter(str) {
        this.contactRenderer.clearAll();
        const searchResult = this.fakeContacts
            .filter(value => value.firstName.toLowerCase().includes(str) || value.lastName.toLowerCase().includes(str));
        this.contactRenderer.renderContacts(searchResult);
    }

    reloadAll() {
        this.contactRenderer.clearAll();
        this.getAll();
    }
}
