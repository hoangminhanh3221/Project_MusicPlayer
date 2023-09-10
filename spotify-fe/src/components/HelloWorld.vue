<template>
  <div>
    <button @click="getData">Lấy dữ liệu từ API</button>
    <div v-if="responseData">
      <h2>Kết quả:</h2>
      <pre>{{ responseData }}</pre>
    </div>
  </div>
</template>

<script>
import { ref } from "vue"; // Import ref từ Vue 3
import axios from "axios"; // Import thư viện Axios

export default {
  name: "HelloWorld",
  setup() {
    const responseData = ref(null); // Sử dụng ref để khai báo trạng thái

    async function getData() {
      try {
        const response = await axios.get(
          "http://localhost:8080/api/account/getAll"
        );
        responseData.value = response.data; // Gán giá trị cho trạng thái thông qua .value
        console.log(response.data);
      } catch (error) {
        console.error("Lỗi khi lấy dữ liệu từ API:", error);
      }
    }

    return {
      responseData,
      getData, // Trả về hàm getData để có thể sử dụng trong template
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
