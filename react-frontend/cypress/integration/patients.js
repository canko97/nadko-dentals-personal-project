import { cyan } from "@material-ui/core/colors"

describe("tests patients crud functionality", ()=>{

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

    it("log in",()=> {
        cy.findByText("dentist").should("exist");
    });

    it("search for a patient", ()=> {
        /* ==== Generated with Cypress Studio ==== */
        cy.get('.mr-auto > :nth-child(2) > .nav-link').click();
        cy.get('input').clear();
        cy.get('input').type('tsanko');
        /* ==== End Cypress Studio ==== */
        cy.findByText("Tsanko").should("exist");
        cy.findByText("Nedelchev").should("exist");
    });

    it("adds new patient", ()=> {
        cy.get('.mr-auto > :nth-child(2) > .nav-link').click();
        /* ==== Generated with Cypress Studio ==== */
        cy.get('.add-button > .btn').click();
        cy.get(':nth-child(1) > .form-control').clear();
        cy.get(':nth-child(1) > .form-control').type('test');
        cy.get(':nth-child(2) > .form-control').clear();
        cy.get(':nth-child(2) > .form-control').type('test');
        cy.get(':nth-child(3) > .form-control').clear();
        cy.get(':nth-child(3) > .form-control').type('test@gmail.com');
        cy.get(':nth-child(4) > .form-control').clear();
        cy.get(':nth-child(4) > .form-control').type('+3112837621');
        cy.get('.btn-success').click();
        /* ==== End Cypress Studio ==== */
        cy.findAllByText("test").should("exist");
    });

    it("edit patient", ()=> {
        cy.get('.mr-auto > :nth-child(2) > .nav-link').click();
        /* ==== Generated with Cypress Studio ==== */
        cy.get(':nth-child(5) > :nth-child(5) > .btn-info').click();
        cy.get(':nth-child(1) > .form-control').clear();
        cy.get(':nth-child(1) > .form-control').type('testedit');
        cy.get('.btn-success').click();
        /* ==== End Cypress Studio ==== */
    });

    it("view patient", ()=> {
        cy.get('.mr-auto > :nth-child(2) > .nav-link').click();
        /* ==== Generated with Cypress Studio ==== */
        cy.get(':nth-child(1) > :nth-child(5) > .btn-success').click();
        /* ==== End Cypress Studio ==== */
        cy.findAllByText("NOTES").should("exist");
        cy.findAllByText("First Name: Tsanko").should("exist");
    });

    it("delete patient", ()=> {
        cy.get('.mr-auto > :nth-child(2) > .nav-link').click();
        /* ==== Generated with Cypress Studio ==== */
        cy.get(':nth-child(5) > :nth-child(5) > .btn-danger').click();
        cy.get('.MuiButton-containedSecondary > .MuiButton-label').click();
        /* ==== End Cypress Studio ==== */
    });
})