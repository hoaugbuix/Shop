import React from "react";
import Input from "../Input";
import "./Navbar.styles.scss";

const Navbar: React.FC = () => {
    return (
        <div className="wrapper">
            <nav>
                <a href="_" className="logo">AAA</a>
                <div>
                    <Input placeholder="Search" />
                </div>
                <ul>
                    <li>
                        <a href="_">About</a>
                    </li>
                    <li>
                        <a href="_">Features</a>
                    </li>
                    <li>
                        <a href="/cart">Cart</a>
                    </li>
                    <li>
                        <a href="_">FAQ</a>
                    </li>
                    <li>
                        <a href="_">Contacts</a>
                    </li>
                </ul>
            </nav>
        </div>
    )
};
export default Navbar;