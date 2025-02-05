package com.coupon.controller;

import com.coupon.dto.Coupon;
import com.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {
    private CouponService couponService;
    @Autowired
public CouponController(CouponService couponService){
    this.couponService=couponService;
}
@GetMapping("/coupon/{couponCode}")
public Coupon getCouponByCode(@PathVariable String couponCode){
    return couponService.getCouponByCode(couponCode);
}
}
