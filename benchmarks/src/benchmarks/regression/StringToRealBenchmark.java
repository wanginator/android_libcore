/*
 * Copyright (C) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package benchmarks.regression;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class StringToRealBenchmark extends SimpleBenchmark {

    @Param({
        "NaN",
        "-1",
        "0",
        "1",
        "1.2",
        "-123.45",
        "-123.45e8",
        "-123.45e36"
    }) String string;

    public void timeFloat_parseFloat(int reps) {
        for (int rep = 0; rep < reps; ++rep) {
            Float.parseFloat(string);
        }
    }

    public void timeDouble_parseDouble(int reps) {
        for (int rep = 0; rep < reps; ++rep) {
            Double.parseDouble(string);
        }
    }
}
