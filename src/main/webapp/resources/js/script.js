const deleteAlert = () => {
  if (!confirm("Are you sure to delete this customer")) {
    return false;
  }
};

const logout = () => {
  document.getElementById("logout").submit();
};
