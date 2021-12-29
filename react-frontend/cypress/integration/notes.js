describe("tests notes crud functionality", ()=>{

    beforeEach(()=>{

        cy.visit("/login")
        /* ==== Generated with Cypress Studio ==== */
        cy.get(':nth-child(1) > div > .form-control').clear();
        cy.get(':nth-child(1) > div > .form-control').type('dentist');
        cy.get(':nth-child(2) > div > .form-control').clear();
        cy.get(':nth-child(2) > div > .form-control').type('password');
        cy.get('.btn > span').click();
        cy.get('.mr-auto > :nth-child(2) > .nav-link').click();
        cy.get(':nth-child(1) > :nth-child(5) > .btn-success').click();
        /* ==== End Cypress Studio ==== */

    });

    it("view notes",()=> {
        cy.findAllByText("NOTES").should("exist");
    });

    it("add new note",()=> {
        cy.findByText("NOTES").should("exist");
        /* ==== Generated with Cypress Studio ==== */
        cy.get('.row > .btn').click();
        cy.get('.form-control').click();
        cy.get('.form-control').clear();
        cy.get('.form-control').type('new note');
        cy.get('.btn-success').click();
        /* ==== End Cypress Studio ==== */
        cy.findAllByText("new note").should("exist");
    });

    it("edit note",()=> {
        cy.findAllByText("NOTES").should("exist");

        /* ==== Generated with Cypress Studio ==== */

        cy.get(
            ':nth-child(3) > [style="background-color: rgb(23, 162, 184); color: white; min-height: 30px; border-radius: 5px 5px 0px 0px; padding-left: 10px; display: flex; justify-content: space-between;"] > [style="display: flex; justify-content: flex-end;"] > :nth-child(1) > .MuiSvgIcon-root > [d="M20.71 7.04c.39-.39.39-1.02 0-1.41l-2.34-2.34c-.2-.2-.45-.29-.71-.29s-.51.1-.7.29l-1.83 1.83 3.75 3.75 1.83-1.83zM3 17.25V21h3.75L17.81 9.94l-3.75-3.75L3 17.25zM5.92 19H5v-.92l9.06-9.06.92.92L5.92 19z"]'
        ).click({force: true});

        cy.get('.form-control').click();
        cy.get('.form-control').clear();
        cy.get('.form-control').type('new note edited');
        cy.get('.btn-success').click();
        /* ==== End Cypress Studio ==== */
        cy.findAllByText("new note edited").should("exist");
    });

    it("delete note",()=> {
        cy.findAllByText("NOTES").should("exist");

        /* ==== Generated with Cypress Studio ==== */

        cy.get(
            ':nth-child(3) > [style="background-color: rgb(23, 162, 184); color: white; min-height: 30px; border-radius: 5px 5px 0px 0px; padding-left: 10px; display: flex; justify-content: space-between;"] > [style="display: flex; justify-content: flex-end;"] > :nth-child(2) > .MuiSvgIcon-root > [d="M15.5 4l-1-1h-5l-1 1H5v2h14V4zM6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zM8 9h8v10H8V9z"]'
        ).click({force: true});

        /* ==== End Cypress Studio ==== */

        cy.findAllByText("new note edited").should("not.exist");
    });
})