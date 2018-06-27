package com.ming.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ming.beans.Book;
import com.ming.beans.ProductCart;
import com.ming.beans.ProductUnit;
import com.ming.services.BookService;

@Controller
public class CartController {
	@Autowired
	private BookService bookService;
	@RequestMapping("/cart")
	public String  addCart(HttpServletRequest request,HttpSession session) {
		String action=request.getParameter("operate");
		System.out.println(action);
		String result=null;
		if(action.equals("addProduct")) {
			result=putProductInCart(request);
		}else if(action.equals("delete")) {
			result=deleteProductCart(request);
		}else if(action.equals("clear")) {
			result=clearProductCart(request);
		}else if(action.equals("view")) {
			result=viewCart(request);
		}
		return result;
	}
	@RequestMapping("/setProductCart")
	public String setCart(HttpServletRequest request) {
		String result=setProductCart(request);
		return result;
	}
	
	public String putProductInCart(HttpServletRequest request) {
		ProductCart productcart=new ProductCart();
		int id=Integer.parseInt(request.getParameter("id"));
		ProductUnit productUnit=new ProductUnit();
		Book product=bookService.selectById(id);
		productUnit.setProduct(product);
		HttpSession session=request.getSession();
		Object cart=session.getAttribute("productCart");
		if(cart instanceof ProductCart) {
			ProductCart recart=	(ProductCart) cart;
			if(!recart.equals(product)) {
				productUnit.setCount(1);
				recart.add(productUnit);
				session.setAttribute("productCart",recart);				
			}
		}else {
			productUnit.setCount(1);
			productcart.add(productUnit);	
			session.setAttribute("productCart",productcart);	
		}
		productcart = (ProductCart) session.getAttribute("productCart");
		request.setAttribute("totalcost", productcart.getTotalCost());
		return "user/cart";
	}
	public String deleteProductCart(HttpServletRequest request) {
		int id=Integer.parseInt(request.getParameter("id"));
		Object productCart=request.getSession().getAttribute("productCart");
		if(productCart!=null) {
			if(productCart instanceof ProductCart) {
				((ProductCart) productCart).delete(id);
			}
		}
		request.setAttribute("totalcost", ((ProductCart) productCart).getTotalCost());
		return "user/cart";
	}
	public String clearProductCart(HttpServletRequest request) {
		Object productCart=request.getSession().getAttribute("productCart");
		if(productCart!=null) {
			if(productCart instanceof ProductCart) {
				((ProductCart) productCart).clear();
			}
		}
		System.out.println("clear");
		
		request.setAttribute("totalcost", ((ProductCart) productCart).getTotalCost());
		return "user/cart";
	}
	public String setProductCart(HttpServletRequest request) {
		String[] idArr = request.getParameterValues("productid");
		String[] countArr = request.getParameterValues("count");
		HttpSession session = request.getSession();
		ProductCart productCart = (ProductCart) session
				.getAttribute("productCart");
		for (int i = 0; i < idArr.length; i++) {
			for (int j = 0; j < productCart.size(); j++) {
				ProductUnit productUnit = productCart.get(i);
				if (productUnit.getProduct().getId() == Integer
						.parseInt(idArr[i])) {
					productUnit.setCount(Integer.parseInt(countArr[i]));
				}
			}
		}
		request.setAttribute("totalcost", productCart.getTotalCost());
		return "user/cart";
		
	}
	public String viewCart(HttpServletRequest request) {
		Object productCart=request.getSession().getAttribute("productCart");
		if(((ProductCart) productCart)!=null) {
			request.setAttribute("totalcost", ((ProductCart) productCart).getTotalCost());
		}

		return "user/cart";
	}
}
