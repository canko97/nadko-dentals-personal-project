describe("tests the homepage", ()=>{

   it("sign up", ()=>{
       cy.visit("/register");
       /* ==== Generated with Cypress Studio ==== */
       cy.get(':nth-child(1) > div > .form-control').clear();
       cy.get(':nth-child(1) > div > .form-control').type('testDentist');
       cy.get(':nth-child(2) > div > .form-control').clear();
       cy.get(':nth-child(2) > div > .form-control').type('test@gmail.com');
       cy.get(':nth-child(3) > div > .form-control').clear();
       cy.get(':nth-child(3) > div > .form-control').type('password');
       cy.get(':nth-child(4) > div > .form-control').clear();
       cy.get(':nth-child(4) > div > .form-control').type('dentist');
       cy.get('.btn').click({force: true});
       /* ==== End Cypress Studio ==== */
   })

    it("log in",()=> {
        cy.visit("/login")
        /* ==== Generated with Cypress Studio ==== */
        cy.get(':nth-child(1) > div > .form-control').clear();
        cy.get(':nth-child(1) > div > .form-control').type('testDentist');
        cy.get(':nth-child(2) > div > .form-control').clear();
        cy.get(':nth-child(2) > div > .form-control').type('password');
        cy.get('.btn > span').click();
        /* ==== End Cypress Studio ==== */
        cy.findByText("testDentist").should("exist");
    });

})