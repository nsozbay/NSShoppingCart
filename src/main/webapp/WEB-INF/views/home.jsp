<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page session="false"%>


<!-- Carousel
        ================================================== -->
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="first-slide home-image" src="<c:url value="/resources/images/back1.jpg" />" alt="First slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Welcome to NS Shopping Store</h1>
                            <p>NS store believes that fresh ingredients and quality food lead to nutritious, delicious meals. We travel near and far to bring our customers the very best — right to their front doors. </p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="second-slide home-image" src="<c:url value="/resources/images/back2.jpg" />" alt="Second slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Our Success Story</h1>
                            <p>By providing quality products and convenient service, we allow our customers more time to live healthy lives.</p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="third-slide home-image " src="<c:url value="/resources/images/back3.jpg" />" alt="Third slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>We Prefer Green Environment</h1>
                            <p>The Wall Street Journal calls our green delivery time slot "an eco-friendly innovation." Find out other ways we're keeping it green.</p>
                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div><!-- /.carousel -->


        <!-- Marketing messaging and features
        ================================================== -->
        <!-- Wrap the rest of the page in another container to center all the content. -->

        <div class="container marketing">

            <!-- Three columns of text below the carousel -->
            <div class="row">
            	<c:forEach items="${categories}" var="category" varStatus="loop">
                <div class="col-lg-4">
                    <a class="btn btn-default" href="<c:url value="/category/viewCategory/${category.id}"/>" role="button">
                        <img class="img-circle" src="<c:url value="/resources/images/${loop.index}.jpg"/>" alt="Food Image" width="140" height="140">
                    </a>

                    <h2>${category.name}</h2>

                </div>
                </c:forEach>
            </div>

<%@ include file="/WEB-INF/views/template/footer.jsp"%>