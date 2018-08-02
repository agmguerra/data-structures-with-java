import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
		
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		Stack<HtmlTag> htmlElements = null;
		
		if (!tags.isEmpty()) {
			
			
			htmlElements = new Stack<HtmlTag>();
			
			boolean end = false;
			
			HtmlTag tag = tags.remove();
			while (!end) { 
				if (tag.isOpenTag()) {
					htmlElements.push(tag);
				} else {
					if (!tag.isSelfClosing()) {
						if (!htmlElements.isEmpty()) {
							HtmlTag ret = htmlElements.pop();
							if (!tag.matches(ret)) {
								htmlElements.push(ret);
								break;
							}
						} else {
							htmlElements = null;
							break;
						} 
					}
				}
				
				if (tags.isEmpty()) {
					end = true;
				} else {
					tag = tags.remove();					
				} 		

			};
		
		}
		return htmlElements; 
	}
	
	
//	public static void main(String[] args) {
//		try {
//			Queue<HtmlTag> tags = HtmlReader.getTagsFromHtmlFile("test6.html");
//			
//			System.out.println(HtmlValidator.isValidHtml(tags));
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
}

