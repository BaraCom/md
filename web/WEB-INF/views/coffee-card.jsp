<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link href="<c:url value="../../resources/css/coffee_style/coffee_style.css" />" rel="stylesheet" />
    </head>
    <body>
        <div class="wrapper">
            <div class="left_div">
                <div class="logo_1"></div>
                <div class="logo_2"></div>

                <div class="login_reg">
                    <span class="reg">
                        <a href="#">
                            registration
                        </a>
                    </span>
                    <span class="slash">
                        /
                    </span>
                    <span class="login">
                        <a href="#">
                            login
                        </a>
                    </span>
                </div>

                <div class="main_menu">
                    <ul class="main_menu_ul">
                        <li class="main_menu_li">
                            <a href="#" class="a main_a">
                                Главная
                            </a>
                        </li>
                        <li class="main_menu_li">
                            <a href="#" class="a about_a">
                                О кофе
                            </a>
                        </li>
                        <li class="main_menu_li">
                            <a href="#" class="a contacts_a">
                                Контакты
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="body_div">
                <form action="/coffee-card" method="post">
                    <div class="middle_div">
                        <p class="coffee_card">
                            - Coffee card -
                        </p>
                        <div class="coffee_type_main">
                            <c:forEach items="${propositionList}" var="coffee_proposition">
                                <div class="coffee_type">
                                    <p class="type">
                                            ${coffee_proposition.name}
                                    </p>
                                    <div class="coffee_bg">
                                        <p class="price">
                                            UAH:

                                            <span class="price_span">
                                                ${coffee_proposition.price}
                                            </span>
                                        </p>
                                        <p class="btn_coffee_type">
                                            <button type="submit" name="coffee-name" class="btn_coffee_type_link"
                                                    value="${coffee_proposition.name}">
                                                Add
                                            </button>
                                        </p>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="right_div">
                        <input type="number" class="spinner" min="0" max="10" name="spinner-num" placeholder="1 count"/>
                    </div>
                </form>
                <div class="footer">
                    <p class="order_list">
                        Order list
                    </p>
                    <div class="footer_order">
                        <c:forEach items="${orderList}" var="coffee_order">
                            <div class="order">
                                <div class="order_left_div">
                                    <div class="order_coffee_type_div">
                                        <span class="coffee_type_span">
                                                ${coffee_order.name}
                                        </span>
                                        <span class="coffee_type_line">
                                            |
                                        </span>
                                    </div>
                                    <div class="order_currency">
                                        <span class="currency">
                                            UAH
                                        </span>
                                        <span class="order_currency_line">
                                            |
                                        </span>
                                    </div>
                                </div>
                                <div class="order_right_div">
                                    <div class="order_quantity_cups">
                                        <span class="quantity_cups">
                                                ${coffee_order.countCups}
                                        </span>
                                    </div>
                                    <div class="order_currency">
                                        <span class="currency_num">
                                                ${coffee_order.price}
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>

                    <div class="total_buy">
                        <div class="total">
                            <span class="total_price">
                                All:
                            </span>
                            <span class="total_price_quantity">
                                ${totalPrice}
                            </span>
                        </div>
                        <div class="buy">
                            <a href="#">
                                <span class="buy_span">
                                    Buy
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
