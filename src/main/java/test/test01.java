package test;

public class test01 {
	/*
	 * getDo(){ // reponse.setContentType("text/html; charset=utf-8"); BlogPost post
	 * = service.getRecentPost(); Map<String, Object> model = new HashMap<String,
	 * Object>(); String html = TemplateFactory.viewResolve("fanadesh/index",model);
	 * // String html = TemplateFactory.viewResolve("fanadesh/index",null);
	 * request.setAttribute("content",html); reponse.getWriter().append(html); }
	 * 
	 * // create templateEngine public class TemplateFactory{
	 * 
	 * 
	 * 
	 * public static String viewResolve(String viewName, Map<String, Object> model){
	 * Context context = new Context();
	 * context.setVariable("locale",Locale.getDefault()); if(model!=null){
	 * model.keySet().forEach(k -> { context.setVariable(k, model.get(k)); });
	 * return templateEngine.provess(viewName, context); } }
	 * 
	 * 
	 */

	/*
	 * //DAO //sql ? SELECT * FROM blog_post ORDER BY id DESC LIMIT 1;
	 * //Class.forName(""); //Init sqlFactory = getSqlSessionFactory(); SqlSession
	 * session = sqlFactory.openSession(); //create factory //
	 * session.insert("blog.post.insert",arg); //run query sql return
	 * (BlogPost)session.selectOne("blog.post.insert"); // session.commit(); //
	 * process sql // return null; // return
	 * 
	 * 
	 */

	/*
	 * query SELECT * FROM blog_post ORDER BY id DESC LIMIT 1; //(desc = dao nguoc)
	 * // SELECT * FROM blog_post ORDER BY id aSC LIMIT 1; = SELECT * FROM blog_post
	 * ORDER BY id LIMIT 1; // SELECT * FROM blog_post ORDER BY date_published desc
	 * LIMIT 1;
	 */

	/*
	 * Controller controller = new HomeController(); //Controller = parent/interface
	 * //use overice or
	 * 
	 * 
	 * Map<String, Object> rt = controller.execute(); String viewName =
	 * (String)rt.get("viewUrl"); Map<String, Object> model = (Map<String,
	 * Object>)rt.get("datas"); //view String html =
	 * TemplateFactory.viewResolve(viewName, model);
	 * response.getWrite().append(html);
	 * 
	 */
}
