<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	
<c:forEach items="${entregas}" var="entrega">
    <tr>      
        <td>${entrega.idMapa}</td>
        <td>${entrega.nomeMapa}</td>
        <td>${entrega.origem}</td>
        <td>${entrega.destino}</td>
        <td>${entrega.distancia}</td>  
        <td>${entrega.autonomia}</td>  
        <td>${entrega.valorLitro}</td>  
        <td>${entrega.custo}</td>  
    </tr>
</c:forEach>
</body>
</html>