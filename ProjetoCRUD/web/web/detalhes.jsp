<%@include file="_header.jsp" %>
<%@include file="_menu.jsp" %>  

<%@page import="br.com.alfashop.model.Produto" %>
<%@page import="br.com.alfashop.repository.ProdutoDAO" %>
<%
try {
    if (request.getParameter("idp") != null) {
        String sidp = request.getParameter("idp");
        Long idp = Long.parseLong(sidp);
        ProdutoDAO objdao = new ProdutoDAO();
        Produto objpro = objdao.buscarPorId(idp);
        pageContext.setAttribute("pro", objpro);
    } else {
        response.sendRedirect("index.jsp");
    }
}
catch(Exception e) {
    response.sendRedirect("index.jsp");
}
%>
  
  <div class="container px-4 py-4" id="custom-cards">
    <h2 class="pb-2 border-bottom">Detalhes do Produto</h2>
    <div class="row row-cols-1 row-cols-lg-3 align-items-stretch g-4 py-5">
    
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:if test="${pro == null}">
            Produto não encontrado!
        </c:if>
                
        <h3>${pro.nome}</h3>
        <div>
            ${pro.descricao}
        </div>
        <div>
            ${pro.maisinfo}
        </div>
        <div>
            ${pro.peso}
        </div>
        <div>
            ${pro.valor}
        </div>
        
    </div>
  </div>

  
<%@include file="_footer.jsp" %>
