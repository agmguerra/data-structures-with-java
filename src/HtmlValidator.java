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
			
			HtmlTag tag = null; 
			do { 
				tag = tags.remove();
				if (tag.isOpenTag() && !tag.isSelfClosing()) {
					htmlElements.push(tag);
				} if (tag.isSelfClosing()) {
					continue;
				} else if (tag.getElement().equals("<!doctype>") ||
						tag.getElement().equals("<!-- -->")) {
						continue;
				} else {
					if (!htmlElements.isEmpty()) {
						HtmlTag ret = htmlElements.pop();
						if (!tag.matches(ret)) {
							htmlElements.push(ret);
							break;
						}
					} else {
						if (tag.isSelfClosing()) {
							htmlElements = null;
							break;
						}
					} 
				}
			} while (!tags.isEmpty());
		
		}
		return htmlElements; 
	}
}

