<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="products">
    <jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#birthDate").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <form:form modelAttribute="product"
                   class="form-horizontal">

            <div class="form-group has-feedback">
                
                <petclinic:inputField label="Name" name="name"/>
                <petclinic:inputField label="Price" name="price"/>
                <div class="control-group">
                    <petclinic:selectField name="productType" label="Product type " names="${productType}" size="5"/>
                </div>
            </div>
            <input type="hidden" name="id" value="{card.id}">
            <button class="btn btn-default" type="submit">Add Product</button>
           
        </form:form>
    </jsp:body>
</petclinic:layout>
