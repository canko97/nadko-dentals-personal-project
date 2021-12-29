import React from 'react'

const Pagination = ({notesPerPage, totalNotes, paginate}) => {

    const pageNumbers = [];

    for(let i=1; i <= Math.ceil(totalNotes/notesPerPage); i++){
        pageNumbers.push(i);
    }

    return (
        <div >
            <ul style={{paddingLeft: "10px", listStyleType: "none", display:"flex"}} className="pagiantion">
                <li style={{display: "flex", alignItems: "center", justifyContent: "center", marginRight: "10px"}}>Pages:</li>
                {pageNumbers.map(number => (
                    <li style={{width: "30px", cursor:"pointer"}} key = {number} className="page-item">
                        <a onClick={()=> paginate(number)} className="page-link">
                            {number}
                        </a>
                    </li>
                ))}
            </ul>
            
        </div>
    )
}

export default Pagination