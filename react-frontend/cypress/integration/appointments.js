describe("tests appointments crud functionality", ()=>{

    beforeEach(()=>{

        cy.visit("/login")
        /* ==== Generated with Cypress Studio ==== */
        cy.get(':nth-child(1) > div > .form-control').clear();
        cy.get(':nth-child(1) > div > .form-control').type('dentist');
        cy.get(':nth-child(2) > div > .form-control').clear();
        cy.get(':nth-child(2) > div > .form-control').type('password');
        cy.get('.btn > span').click();
        /* ==== End Cypress Studio ==== */

    });

    it("add new appointment",()=> {
        cy.get('.mr-auto > :nth-child(3) > .nav-link').click();
        cy.findAllByText("Appointments").should("exist");
        /* ==== Generated with Cypress Studio ==== */
        cy.get('.add-button > .btn').click();
        cy.get('#patient').select('21');
        cy.get('#appointmentDateTime').clear();
        cy.get('#appointmentDateTime').type('2021-06-18T23:30');
        cy.get('.btn-success').click();
        /* ==== End Cypress Studio ==== */
        cy.findAllByText("2021-06-18 23:30").should("exist");
    });
    
    it("edit appointment",()=> {
        cy.get('.mr-auto > :nth-child(3) > .nav-link').click();
        cy.findAllByText("Appointments").should("exist");
        /* ==== Generated with Cypress Studio ==== */
        cy.get(':nth-child(3) > :nth-child(3) > .btn-info').click();
        cy.get('#appointmentDateTime').clear();
        cy.get('#appointmentDateTime').type('2021-06-19T23:30');
        cy.get('.btn-success').click();
        /* ==== End Cypress Studio ==== */
        cy.findAllByText("2021-06-19 23:30").should("exist");
    });

    it("delete appointment",()=> {
        cy.get('.mr-auto > :nth-child(3) > .nav-link').click();
        cy.findAllByText("Appointments").should("exist");
        /* ==== Generated with Cypress Studio ==== */
        cy.get(':nth-child(3) > :nth-child(3) > .btn-danger').click();
        /* ==== End Cypress Studio ==== */
        cy.findAllByText("2021-06-19 23:30").should("not.exist");

    });
})
