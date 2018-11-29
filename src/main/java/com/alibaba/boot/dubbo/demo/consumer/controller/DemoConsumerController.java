/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.boot.dubbo.demo.consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.deepexi.service.ProductService;
import com.deepexi.util.config.Payload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo Consumer Controller (REST)
 *
 * RestController
 */
@RestController
@RequestMapping("/consumer")
public class DemoConsumerController {

    @Reference(version = "${demo.service.version}")
    private ProductService productService;

    @RequestMapping("/getById")
    public Payload getById(@RequestParam String id) {
        return new Payload(productService.getProductById(id));
    }

}
