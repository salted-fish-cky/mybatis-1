/**
 *    Copyright ${license.git.copyrightYears} the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.test;

import java.util.List;
import java.util.Map;

/**
 * 需要视频资料或者咨询课程的可以加若曦老师的QQ：2408349392
 * author：鲁班学院-商鞅老师
 */
//@Alias("DemoMapper")
public interface DemoMapper {

//    @Select()
  // arg0 arg1 arg2
  public List<Map<String,Object>>  selectAll(String id, String name);

  public void insert(String name,String age);

  default void test(){
    System.out.println(111);

  }
}
